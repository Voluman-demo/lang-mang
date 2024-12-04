"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
var __classPrivateFieldGet = (this && this.__classPrivateFieldGet) || function (receiver, state, kind, f) {
    if (kind === "a" && !f) throw new TypeError("Private accessor was defined without a getter");
    if (typeof state === "function" ? receiver !== state || !f : !state.has(receiver)) throw new TypeError("Cannot read private member from an object whose class did not declare it");
    return kind === "m" ? f : kind === "a" ? f.call(receiver) : f ? f.value : state.get(receiver);
};
Object.defineProperty(exports, "__esModule", { value: true });
exports.google = void 0;
/**
 * Generated by the protoc-gen-ts.  DO NOT EDIT!
 * compiler version: 5.29.0
 * source: google/protobuf/empty.proto
 * git: https://github.com/thesayyn/protoc-gen-ts */
var pb_1 = require("google-protobuf");
var google;
(function (google) {
    var protobuf;
    (function (protobuf) {
        var _Empty_one_of_decls;
        var Empty = /** @class */ (function (_super) {
            __extends(Empty, _super);
            function Empty(data) {
                var _this = _super.call(this) || this;
                _Empty_one_of_decls.set(_this, []);
                pb_1.Message.initialize(_this, Array.isArray(data) ? data : [], 0, -1, [], __classPrivateFieldGet(_this, _Empty_one_of_decls, "f"));
                if (!Array.isArray(data) && typeof data == "object") { }
                return _this;
            }
            Empty.fromObject = function (data) {
                var message = new Empty({});
                return message;
            };
            Empty.prototype.toObject = function () {
                var data = {};
                return data;
            };
            Empty.prototype.serialize = function (w) {
                var writer = w || new pb_1.BinaryWriter();
                if (!w)
                    return writer.getResultBuffer();
            };
            Empty.deserialize = function (bytes) {
                var reader = bytes instanceof pb_1.BinaryReader ? bytes : new pb_1.BinaryReader(bytes), message = new Empty();
                while (reader.nextField()) {
                    if (reader.isEndGroup())
                        break;
                    switch (reader.getFieldNumber()) {
                        default: reader.skipField();
                    }
                }
                return message;
            };
            Empty.prototype.serializeBinary = function () {
                return this.serialize();
            };
            Empty.deserializeBinary = function (bytes) {
                return Empty.deserialize(bytes);
            };
            return Empty;
        }(pb_1.Message));
        _Empty_one_of_decls = new WeakMap();
        protobuf.Empty = Empty;
    })(protobuf = google.protobuf || (google.protobuf = {}));
})(google || (exports.google = google = {}));
