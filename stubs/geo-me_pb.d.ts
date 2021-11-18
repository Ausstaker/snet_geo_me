// package: 
// file: geo-me.proto

import * as jspb from "google-protobuf";

export class GeoRequest extends jspb.Message {
  clearObservationList(): void;
  getObservationList(): Array<Observation>;
  setObservationList(value: Array<Observation>): void;
  addObservation(value?: Observation, index?: number): Observation;

  hasTarget(): boolean;
  clearTarget(): void;
  getTarget(): Target | undefined;
  setTarget(value?: Target): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): GeoRequest.AsObject;
  static toObject(includeInstance: boolean, msg: GeoRequest): GeoRequest.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: GeoRequest, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): GeoRequest;
  static deserializeBinaryFromReader(message: GeoRequest, reader: jspb.BinaryReader): GeoRequest;
}

export namespace GeoRequest {
  export type AsObject = {
    observationList: Array<Observation.AsObject>,
    target?: Target.AsObject,
  }
}

export class Target extends jspb.Message {
  getId(): string;
  setId(value: string): void;

  getName(): string;
  setName(value: string): void;

  getTrueLat(): number;
  setTrueLat(value: number): void;

  getTrueLon(): number;
  setTrueLon(value: number): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): Target.AsObject;
  static toObject(includeInstance: boolean, msg: Target): Target.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: Target, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): Target;
  static deserializeBinaryFromReader(message: Target, reader: jspb.BinaryReader): Target;
}

export namespace Target {
  export type AsObject = {
    id: string,
    name: string,
    trueLat: number,
    trueLon: number,
  }
}

export class Observation extends jspb.Message {
  getId(): number;
  setId(value: number): void;

  getAssetid(): string;
  setAssetid(value: string): void;

  getLat(): number;
  setLat(value: number): void;

  getLon(): number;
  setLon(value: number): void;

  getX(): number;
  setX(value: number): void;

  getY(): number;
  setY(value: number): void;

  getMeas(): number;
  setMeas(value: number): void;

  getTargetid(): string;
  setTargetid(value: string): void;

  getType(): string;
  setType(value: string): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): Observation.AsObject;
  static toObject(includeInstance: boolean, msg: Observation): Observation.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: Observation, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): Observation;
  static deserializeBinaryFromReader(message: Observation, reader: jspb.BinaryReader): Observation;
}

export namespace Observation {
  export type AsObject = {
    id: number,
    assetid: string,
    lat: number,
    lon: number,
    x: number,
    y: number,
    meas: number,
    targetid: string,
    type: string,
  }
}

export class GeolocationResult extends jspb.Message {
  getResidual(): number;
  setResidual(value: number): void;

  getResidualRk(): number;
  setResidualRk(value: number): void;

  getLat(): number;
  setLat(value: number): void;

  getLon(): number;
  setLon(value: number): void;

  getElpLong(): number;
  setElpLong(value: number): void;

  getElpShort(): number;
  setElpShort(value: number): void;

  getElpRot(): number;
  setElpRot(value: number): void;

  serializeBinary(): Uint8Array;
  toObject(includeInstance?: boolean): GeolocationResult.AsObject;
  static toObject(includeInstance: boolean, msg: GeolocationResult): GeolocationResult.AsObject;
  static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
  static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
  static serializeBinaryToWriter(message: GeolocationResult, writer: jspb.BinaryWriter): void;
  static deserializeBinary(bytes: Uint8Array): GeolocationResult;
  static deserializeBinaryFromReader(message: GeolocationResult, reader: jspb.BinaryReader): GeolocationResult;
}

export namespace GeolocationResult {
  export type AsObject = {
    residual: number,
    residualRk: number,
    lat: number,
    lon: number,
    elpLong: number,
    elpShort: number,
    elpRot: number,
  }
}

