package com.example.demo.Rpc;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;


@RestController
@RequestMapping("/api/rpc")
public class RpcController {
    private final RpcService rpcService;


    public RpcController(RpcService rpcService) {
        this.rpcService = rpcService;
    }

    @GetMapping
    public ResponseEntity<?> handleRpcCallGet(
            @RequestParam("method") String method,
            @RequestParam Map<String, String> params
    ) {
        return switch (method) {
            case "getAllLanguages" -> rpcService.handleGetAllLanguages();
            case "addLanguage" -> rpcService.handleAddLanguage(params);
            case "removeLanguage" -> rpcService.removeLanguage(params);
            case "clearLanguages" -> rpcService.clearLanguages();
            case "getAllDocuments" -> rpcService.handleGetAllDocuments(params);
            case "getOutdatedDocuments" -> rpcService.handleGetOutdatedDocuments(params);
            case "downloadFile" -> rpcService.handleDownloadFile(params);
            default -> ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Unknown method: " + method);
        };
    }

    @PostMapping
    public ResponseEntity<?> handleRpcCallPost(
            @RequestParam("method") String method,
            @RequestParam Map<String, String> params,
            @RequestParam(value = "documentFile", required = false) MultipartFile file
    ) {
        return switch (method) {
            case "addDocument" -> rpcService.handleAddDocument(params, file);
            default -> ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Unknown method: " + method);
        };
    }
}