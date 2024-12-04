"use strict";
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    var desc = Object.getOwnPropertyDescriptor(m, k);
    if (!desc || ("get" in desc ? !m.__esModule : desc.writable || desc.configurable)) {
      desc = { enumerable: true, get: function() { return m[k]; } };
    }
    Object.defineProperty(o, k2, desc);
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || (function () {
    var ownKeys = function(o) {
        ownKeys = Object.getOwnPropertyNames || function (o) {
            var ar = [];
            for (var k in o) if (Object.prototype.hasOwnProperty.call(o, k)) ar[ar.length] = k;
            return ar;
        };
        return ownKeys(o);
    };
    return function (mod) {
        if (mod && mod.__esModule) return mod;
        var result = {};
        if (mod != null) for (var k = ownKeys(mod), i = 0; i < k.length; i++) if (k[i] !== "default") __createBinding(result, mod, k[i]);
        __setModuleDefault(result, mod);
        return result;
    };
})();
var __classPrivateFieldGet = (this && this.__classPrivateFieldGet) || function (receiver, state, kind, f) {
    if (kind === "a" && !f) throw new TypeError("Private accessor was defined without a getter");
    if (typeof state === "function" ? receiver !== state || !f : !state.has(receiver)) throw new TypeError("Cannot read private member from an object whose class did not declare it");
    return kind === "m" ? f : kind === "a" ? f.call(receiver) : f ? f.value : state.get(receiver);
};
var _Empty_one_of_decls, _LanguageRequest_one_of_decls, _Language_one_of_decls, _LanguageList_one_of_decls, _Response_one_of_decls;
Object.defineProperty(exports, "__esModule", { value: true });
exports.LanguageServiceClient = exports.UnimplementedLanguageServiceService = exports.Response = exports.LanguageList = exports.Language = exports.LanguageRequest = exports.Empty = void 0;
/**
 * Generated by the protoc-gen-ts.  DO NOT EDIT!
 * compiler version: 5.29.0
 * source: language.proto
 * git: https://github.com/thesayyn/protoc-gen-ts */
const pb_1 = __importStar(require("google-protobuf"));
const grpc_1 = __importStar(require("@grpc/grpc-js"));
class Empty extends pb_1.Message {
    constructor(data) {
        super();
        _Empty_one_of_decls.set(this, []);
        pb_1.Message.initialize(this, Array.isArray(data) ? data : [], 0, -1, [], __classPrivateFieldGet(this, _Empty_one_of_decls, "f"));
        if (!Array.isArray(data) && typeof data == "object") { }
    }
    static fromObject(data) {
        const message = new Empty({});
        return message;
    }
    toObject() {
        const data = {};
        return data;
    }
    serialize(w) {
        const writer = w || new pb_1.BinaryWriter();
        if (!w)
            return writer.getResultBuffer();
    }
    static deserialize(bytes) {
        const reader = bytes instanceof pb_1.BinaryReader ? bytes : new pb_1.BinaryReader(bytes), message = new Empty();
        while (reader.nextField()) {
            if (reader.isEndGroup())
                break;
            switch (reader.getFieldNumber()) {
                default: reader.skipField();
            }
        }
        return message;
    }
    serializeBinary() {
        return this.serialize();
    }
    static deserializeBinary(bytes) {
        return Empty.deserialize(bytes);
    }
}
exports.Empty = Empty;
_Empty_one_of_decls = new WeakMap();
class LanguageRequest extends pb_1.Message {
    constructor(data) {
        super();
        _LanguageRequest_one_of_decls.set(this, []);
        pb_1.Message.initialize(this, Array.isArray(data) ? data : [], 0, -1, [], __classPrivateFieldGet(this, _LanguageRequest_one_of_decls, "f"));
        if (!Array.isArray(data) && typeof data == "object") {
            if ("code" in data && data.code != undefined) {
                this.code = data.code;
            }
        }
    }
    get code() {
        return pb_1.Message.getFieldWithDefault(this, 1, "");
    }
    set code(value) {
        pb_1.Message.setField(this, 1, value);
    }
    static fromObject(data) {
        const message = new LanguageRequest({});
        if (data.code != null) {
            message.code = data.code;
        }
        return message;
    }
    toObject() {
        const data = {};
        if (this.code != null) {
            data.code = this.code;
        }
        return data;
    }
    serialize(w) {
        const writer = w || new pb_1.BinaryWriter();
        if (this.code.length)
            writer.writeString(1, this.code);
        if (!w)
            return writer.getResultBuffer();
    }
    static deserialize(bytes) {
        const reader = bytes instanceof pb_1.BinaryReader ? bytes : new pb_1.BinaryReader(bytes), message = new LanguageRequest();
        while (reader.nextField()) {
            if (reader.isEndGroup())
                break;
            switch (reader.getFieldNumber()) {
                case 1:
                    message.code = reader.readString();
                    break;
                default: reader.skipField();
            }
        }
        return message;
    }
    serializeBinary() {
        return this.serialize();
    }
    static deserializeBinary(bytes) {
        return LanguageRequest.deserialize(bytes);
    }
}
exports.LanguageRequest = LanguageRequest;
_LanguageRequest_one_of_decls = new WeakMap();
class Language extends pb_1.Message {
    constructor(data) {
        super();
        _Language_one_of_decls.set(this, []);
        pb_1.Message.initialize(this, Array.isArray(data) ? data : [], 0, -1, [], __classPrivateFieldGet(this, _Language_one_of_decls, "f"));
        if (!Array.isArray(data) && typeof data == "object") {
            if ("code" in data && data.code != undefined) {
                this.code = data.code;
            }
        }
    }
    get code() {
        return pb_1.Message.getFieldWithDefault(this, 1, "");
    }
    set code(value) {
        pb_1.Message.setField(this, 1, value);
    }
    static fromObject(data) {
        const message = new Language({});
        if (data.code != null) {
            message.code = data.code;
        }
        return message;
    }
    toObject() {
        const data = {};
        if (this.code != null) {
            data.code = this.code;
        }
        return data;
    }
    serialize(w) {
        const writer = w || new pb_1.BinaryWriter();
        if (this.code.length)
            writer.writeString(1, this.code);
        if (!w)
            return writer.getResultBuffer();
    }
    static deserialize(bytes) {
        const reader = bytes instanceof pb_1.BinaryReader ? bytes : new pb_1.BinaryReader(bytes), message = new Language();
        while (reader.nextField()) {
            if (reader.isEndGroup())
                break;
            switch (reader.getFieldNumber()) {
                case 1:
                    message.code = reader.readString();
                    break;
                default: reader.skipField();
            }
        }
        return message;
    }
    serializeBinary() {
        return this.serialize();
    }
    static deserializeBinary(bytes) {
        return Language.deserialize(bytes);
    }
}
exports.Language = Language;
_Language_one_of_decls = new WeakMap();
class LanguageList extends pb_1.Message {
    constructor(data) {
        super();
        _LanguageList_one_of_decls.set(this, []);
        pb_1.Message.initialize(this, Array.isArray(data) ? data : [], 0, -1, [1], __classPrivateFieldGet(this, _LanguageList_one_of_decls, "f"));
        if (!Array.isArray(data) && typeof data == "object") {
            if ("languages" in data && data.languages != undefined) {
                this.languages = data.languages;
            }
        }
    }
    get languages() {
        return pb_1.Message.getRepeatedWrapperField(this, Language, 1);
    }
    set languages(value) {
        pb_1.Message.setRepeatedWrapperField(this, 1, value);
    }
    static fromObject(data) {
        const message = new LanguageList({});
        if (data.languages != null) {
            message.languages = data.languages.map(item => Language.fromObject(item));
        }
        return message;
    }
    toObject() {
        const data = {};
        if (this.languages != null) {
            data.languages = this.languages.map((item) => item.toObject());
        }
        return data;
    }
    serialize(w) {
        const writer = w || new pb_1.BinaryWriter();
        if (this.languages.length)
            writer.writeRepeatedMessage(1, this.languages, (item) => item.serialize(writer));
        if (!w)
            return writer.getResultBuffer();
    }
    static deserialize(bytes) {
        const reader = bytes instanceof pb_1.BinaryReader ? bytes : new pb_1.BinaryReader(bytes), message = new LanguageList();
        while (reader.nextField()) {
            if (reader.isEndGroup())
                break;
            switch (reader.getFieldNumber()) {
                case 1:
                    reader.readMessage(message.languages, () => pb_1.Message.addToRepeatedWrapperField(message, 1, Language.deserialize(reader), Language));
                    break;
                default: reader.skipField();
            }
        }
        return message;
    }
    serializeBinary() {
        return this.serialize();
    }
    static deserializeBinary(bytes) {
        return LanguageList.deserialize(bytes);
    }
}
exports.LanguageList = LanguageList;
_LanguageList_one_of_decls = new WeakMap();
class Response extends pb_1.Message {
    constructor(data) {
        super();
        _Response_one_of_decls.set(this, []);
        pb_1.Message.initialize(this, Array.isArray(data) ? data : [], 0, -1, [], __classPrivateFieldGet(this, _Response_one_of_decls, "f"));
        if (!Array.isArray(data) && typeof data == "object") {
            if ("message" in data && data.message != undefined) {
                this.message = data.message;
            }
            if ("success" in data && data.success != undefined) {
                this.success = data.success;
            }
        }
    }
    get message() {
        return pb_1.Message.getFieldWithDefault(this, 1, "");
    }
    set message(value) {
        pb_1.Message.setField(this, 1, value);
    }
    get success() {
        return pb_1.Message.getFieldWithDefault(this, 2, false);
    }
    set success(value) {
        pb_1.Message.setField(this, 2, value);
    }
    static fromObject(data) {
        const message = new Response({});
        if (data.message != null) {
            message.message = data.message;
        }
        if (data.success != null) {
            message.success = data.success;
        }
        return message;
    }
    toObject() {
        const data = {};
        if (this.message != null) {
            data.message = this.message;
        }
        if (this.success != null) {
            data.success = this.success;
        }
        return data;
    }
    serialize(w) {
        const writer = w || new pb_1.BinaryWriter();
        if (this.message.length)
            writer.writeString(1, this.message);
        if (this.success != false)
            writer.writeBool(2, this.success);
        if (!w)
            return writer.getResultBuffer();
    }
    static deserialize(bytes) {
        const reader = bytes instanceof pb_1.BinaryReader ? bytes : new pb_1.BinaryReader(bytes), message = new Response();
        while (reader.nextField()) {
            if (reader.isEndGroup())
                break;
            switch (reader.getFieldNumber()) {
                case 1:
                    message.message = reader.readString();
                    break;
                case 2:
                    message.success = reader.readBool();
                    break;
                default: reader.skipField();
            }
        }
        return message;
    }
    serializeBinary() {
        return this.serialize();
    }
    static deserializeBinary(bytes) {
        return Response.deserialize(bytes);
    }
}
exports.Response = Response;
_Response_one_of_decls = new WeakMap();
class UnimplementedLanguageServiceService {
}
exports.UnimplementedLanguageServiceService = UnimplementedLanguageServiceService;
UnimplementedLanguageServiceService.definition = {
    GetAllLanguages: {
        path: "/LanguageService/GetAllLanguages",
        requestStream: false,
        responseStream: false,
        requestSerialize: (message) => Buffer.from(message.serialize()),
        requestDeserialize: (bytes) => Empty.deserialize(new Uint8Array(bytes)),
        responseSerialize: (message) => Buffer.from(message.serialize()),
        responseDeserialize: (bytes) => LanguageList.deserialize(new Uint8Array(bytes))
    },
    AddLanguage: {
        path: "/LanguageService/AddLanguage",
        requestStream: false,
        responseStream: false,
        requestSerialize: (message) => Buffer.from(message.serialize()),
        requestDeserialize: (bytes) => LanguageRequest.deserialize(new Uint8Array(bytes)),
        responseSerialize: (message) => Buffer.from(message.serialize()),
        responseDeserialize: (bytes) => Response.deserialize(new Uint8Array(bytes))
    },
    RemoveLanguage: {
        path: "/LanguageService/RemoveLanguage",
        requestStream: false,
        responseStream: false,
        requestSerialize: (message) => Buffer.from(message.serialize()),
        requestDeserialize: (bytes) => LanguageRequest.deserialize(new Uint8Array(bytes)),
        responseSerialize: (message) => Buffer.from(message.serialize()),
        responseDeserialize: (bytes) => Response.deserialize(new Uint8Array(bytes))
    },
    ClearLanguages: {
        path: "/LanguageService/ClearLanguages",
        requestStream: false,
        responseStream: false,
        requestSerialize: (message) => Buffer.from(message.serialize()),
        requestDeserialize: (bytes) => Empty.deserialize(new Uint8Array(bytes)),
        responseSerialize: (message) => Buffer.from(message.serialize()),
        responseDeserialize: (bytes) => Response.deserialize(new Uint8Array(bytes))
    }
};
class LanguageServiceClient extends grpc_1.makeGenericClientConstructor(UnimplementedLanguageServiceService.definition, "LanguageService", {}) {
    constructor(address, credentials, options) {
        super(address, credentials, options);
        this.GetAllLanguages = (message, metadata, options, callback) => {
            return super.GetAllLanguages(message, metadata, options, callback);
        };
        this.AddLanguage = (message, metadata, options, callback) => {
            return super.AddLanguage(message, metadata, options, callback);
        };
        this.RemoveLanguage = (message, metadata, options, callback) => {
            return super.RemoveLanguage(message, metadata, options, callback);
        };
        this.ClearLanguages = (message, metadata, options, callback) => {
            return super.ClearLanguages(message, metadata, options, callback);
        };
    }
}
exports.LanguageServiceClient = LanguageServiceClient;
