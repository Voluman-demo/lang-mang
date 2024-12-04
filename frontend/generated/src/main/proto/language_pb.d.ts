import * as jspb from 'google-protobuf'



export class Empty extends jspb.Message {
  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): Empty.AsObject;
  static toObject(includeInstance: boolean, msg: Empty): Empty.AsObject;
  static serializeBinaryToWriter(message: Empty, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): Empty;
  static deserializeBinaryFromReader(message: Empty, reader: jspb.BinaryReader): Empty;
}

export namespace Empty {
  export type AsObject = {
  }
}

export class LanguageRequest extends jspb.Message {
  getCode(): string;
  setCode(value: string): LanguageRequest;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): LanguageRequest.AsObject;
  static toObject(includeInstance: boolean, msg: LanguageRequest): LanguageRequest.AsObject;
  static serializeBinaryToWriter(message: LanguageRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): LanguageRequest;
  static deserializeBinaryFromReader(message: LanguageRequest, reader: jspb.BinaryReader): LanguageRequest;
}

export namespace LanguageRequest {
  export type AsObject = {
    code: string,
  }
}

export class Language extends jspb.Message {
  getCode(): string;
  setCode(value: string): Language;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): Language.AsObject;
  static toObject(includeInstance: boolean, msg: Language): Language.AsObject;
  static serializeBinaryToWriter(message: Language, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): Language;
  static deserializeBinaryFromReader(message: Language, reader: jspb.BinaryReader): Language;
}

export namespace Language {
  export type AsObject = {
    code: string,
  }
}

export class LanguageList extends jspb.Message {
  getLanguagesList(): Array<Language>;
  setLanguagesList(value: Array<Language>): LanguageList;
  clearLanguagesList(): LanguageList;
  addLanguages(value?: Language, index?: number): Language;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): LanguageList.AsObject;
  static toObject(includeInstance: boolean, msg: LanguageList): LanguageList.AsObject;
  static serializeBinaryToWriter(message: LanguageList, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): LanguageList;
  static deserializeBinaryFromReader(message: LanguageList, reader: jspb.BinaryReader): LanguageList;
}

export namespace LanguageList {
  export type AsObject = {
    languagesList: Array<Language.AsObject>,
  }
}

export class Response extends jspb.Message {
  getMessage(): string;
  setMessage(value: string): Response;

  getSuccess(): boolean;
  setSuccess(value: boolean): Response;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): Response.AsObject;
  static toObject(includeInstance: boolean, msg: Response): Response.AsObject;
  static serializeBinaryToWriter(message: Response, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): Response;
  static deserializeBinaryFromReader(message: Response, reader: jspb.BinaryReader): Response;
}

export namespace Response {
  export type AsObject = {
    message: string,
    success: boolean,
  }
}

