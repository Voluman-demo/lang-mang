import * as jspb from 'google-protobuf'

import * as google_protobuf_empty_pb from 'google-protobuf/google/protobuf/empty_pb'; // proto import: "google/protobuf/empty.proto"


export class DocumentRequest extends jspb.Message {
  getLanguagecode(): string;
  setLanguagecode(value: string): DocumentRequest;

  getType(): string;
  setType(value: string): DocumentRequest;

  getVersionList(): Array<number>;
  setVersionList(value: Array<number>): DocumentRequest;
  clearVersionList(): DocumentRequest;
  addVersion(value: number, index?: number): DocumentRequest;

  getFilename(): string;
  setFilename(value: string): DocumentRequest;

  getFilecontent(): Uint8Array | string;
  getFilecontent_asU8(): Uint8Array;
  getFilecontent_asB64(): string;
  setFilecontent(value: Uint8Array | string): DocumentRequest;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): DocumentRequest.AsObject;
  static toObject(includeInstance: boolean, msg: DocumentRequest): DocumentRequest.AsObject;
  static serializeBinaryToWriter(message: DocumentRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): DocumentRequest;
  static deserializeBinaryFromReader(message: DocumentRequest, reader: jspb.BinaryReader): DocumentRequest;
}

export namespace DocumentRequest {
  export type AsObject = {
    languagecode: string,
    type: string,
    versionList: Array<number>,
    filename: string,
    filecontent: Uint8Array | string,
  }
}

export class DocumentAddRequest extends jspb.Message {
  getLanguagecode(): string;
  setLanguagecode(value: string): DocumentAddRequest;

  getType(): string;
  setType(value: string): DocumentAddRequest;

  getVersion(): string;
  setVersion(value: string): DocumentAddRequest;

  getFilename(): string;
  setFilename(value: string): DocumentAddRequest;

  getFilecontent(): Uint8Array | string;
  getFilecontent_asU8(): Uint8Array;
  getFilecontent_asB64(): string;
  setFilecontent(value: Uint8Array | string): DocumentAddRequest;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): DocumentAddRequest.AsObject;
  static toObject(includeInstance: boolean, msg: DocumentAddRequest): DocumentAddRequest.AsObject;
  static serializeBinaryToWriter(message: DocumentAddRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): DocumentAddRequest;
  static deserializeBinaryFromReader(message: DocumentAddRequest, reader: jspb.BinaryReader): DocumentAddRequest;
}

export namespace DocumentAddRequest {
  export type AsObject = {
    languagecode: string,
    type: string,
    version: string,
    filename: string,
    filecontent: Uint8Array | string,
  }
}

export class DocumentResponse extends jspb.Message {
  getMessage(): string;
  setMessage(value: string): DocumentResponse;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): DocumentResponse.AsObject;
  static toObject(includeInstance: boolean, msg: DocumentResponse): DocumentResponse.AsObject;
  static serializeBinaryToWriter(message: DocumentResponse, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): DocumentResponse;
  static deserializeBinaryFromReader(message: DocumentResponse, reader: jspb.BinaryReader): DocumentResponse;
}

export namespace DocumentResponse {
  export type AsObject = {
    message: string,
  }
}

export class GetDocumentsResponse extends jspb.Message {
  getDocumentsList(): Array<Document>;
  setDocumentsList(value: Array<Document>): GetDocumentsResponse;
  clearDocumentsList(): GetDocumentsResponse;
  addDocuments(value?: Document, index?: number): Document;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): GetDocumentsResponse.AsObject;
  static toObject(includeInstance: boolean, msg: GetDocumentsResponse): GetDocumentsResponse.AsObject;
  static serializeBinaryToWriter(message: GetDocumentsResponse, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): GetDocumentsResponse;
  static deserializeBinaryFromReader(message: GetDocumentsResponse, reader: jspb.BinaryReader): GetDocumentsResponse;
}

export namespace GetDocumentsResponse {
  export type AsObject = {
    documentsList: Array<Document.AsObject>,
  }
}

export class DownloadFileRequest extends jspb.Message {
  getFilename(): string;
  setFilename(value: string): DownloadFileRequest;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): DownloadFileRequest.AsObject;
  static toObject(includeInstance: boolean, msg: DownloadFileRequest): DownloadFileRequest.AsObject;
  static serializeBinaryToWriter(message: DownloadFileRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): DownloadFileRequest;
  static deserializeBinaryFromReader(message: DownloadFileRequest, reader: jspb.BinaryReader): DownloadFileRequest;
}

export namespace DownloadFileRequest {
  export type AsObject = {
    filename: string,
  }
}

export class DownloadFileResponse extends jspb.Message {
  getFilecontent(): Uint8Array | string;
  getFilecontent_asU8(): Uint8Array;
  getFilecontent_asB64(): string;
  setFilecontent(value: Uint8Array | string): DownloadFileResponse;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): DownloadFileResponse.AsObject;
  static toObject(includeInstance: boolean, msg: DownloadFileResponse): DownloadFileResponse.AsObject;
  static serializeBinaryToWriter(message: DownloadFileResponse, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): DownloadFileResponse;
  static deserializeBinaryFromReader(message: DownloadFileResponse, reader: jspb.BinaryReader): DownloadFileResponse;
}

export namespace DownloadFileResponse {
  export type AsObject = {
    filecontent: Uint8Array | string,
  }
}

export class CheckOutdatedDocumentsRequest extends jspb.Message {
  getType(): string;
  setType(value: string): CheckOutdatedDocumentsRequest;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): CheckOutdatedDocumentsRequest.AsObject;
  static toObject(includeInstance: boolean, msg: CheckOutdatedDocumentsRequest): CheckOutdatedDocumentsRequest.AsObject;
  static serializeBinaryToWriter(message: CheckOutdatedDocumentsRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): CheckOutdatedDocumentsRequest;
  static deserializeBinaryFromReader(message: CheckOutdatedDocumentsRequest, reader: jspb.BinaryReader): CheckOutdatedDocumentsRequest;
}

export namespace CheckOutdatedDocumentsRequest {
  export type AsObject = {
    type: string,
  }
}

export class CheckOutdatedDocumentsResponse extends jspb.Message {
  getOutdateddocumentsList(): Array<Document>;
  setOutdateddocumentsList(value: Array<Document>): CheckOutdatedDocumentsResponse;
  clearOutdateddocumentsList(): CheckOutdatedDocumentsResponse;
  addOutdateddocuments(value?: Document, index?: number): Document;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): CheckOutdatedDocumentsResponse.AsObject;
  static toObject(includeInstance: boolean, msg: CheckOutdatedDocumentsResponse): CheckOutdatedDocumentsResponse.AsObject;
  static serializeBinaryToWriter(message: CheckOutdatedDocumentsResponse, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): CheckOutdatedDocumentsResponse;
  static deserializeBinaryFromReader(message: CheckOutdatedDocumentsResponse, reader: jspb.BinaryReader): CheckOutdatedDocumentsResponse;
}

export namespace CheckOutdatedDocumentsResponse {
  export type AsObject = {
    outdateddocumentsList: Array<Document.AsObject>,
  }
}

export class Document extends jspb.Message {
  getLanguagecode(): string;
  setLanguagecode(value: string): Document;

  getType(): string;
  setType(value: string): Document;

  getVersionList(): Array<number>;
  setVersionList(value: Array<number>): Document;
  clearVersionList(): Document;
  addVersion(value: number, index?: number): Document;

  getFilepath(): string;
  setFilepath(value: string): Document;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): Document.AsObject;
  static toObject(includeInstance: boolean, msg: Document): Document.AsObject;
  static serializeBinaryToWriter(message: Document, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): Document;
  static deserializeBinaryFromReader(message: Document, reader: jspb.BinaryReader): Document;
}

export namespace Document {
  export type AsObject = {
    languagecode: string,
    type: string,
    versionList: Array<number>,
    filepath: string,
  }
}

