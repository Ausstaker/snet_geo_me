// package: 
// file: geo-me.proto

import * as geo_me_pb from "./geo-me_pb";
import {grpc} from "@improbable-eng/grpc-web";

type ServiceDefinitiongeoFixMe = {
  readonly methodName: string;
  readonly service: typeof ServiceDefinition;
  readonly requestStream: false;
  readonly responseStream: false;
  readonly requestType: typeof geo_me_pb.GeoRequest;
  readonly responseType: typeof geo_me_pb.GeolocationResult;
};

export class ServiceDefinition {
  static readonly serviceName: string;
  static readonly geoFixMe: ServiceDefinitiongeoFixMe;
}

export type ServiceError = { message: string, code: number; metadata: grpc.Metadata }
export type Status = { details: string, code: number; metadata: grpc.Metadata }

interface UnaryResponse {
  cancel(): void;
}
interface ResponseStream<T> {
  cancel(): void;
  on(type: 'data', handler: (message: T) => void): ResponseStream<T>;
  on(type: 'end', handler: (status?: Status) => void): ResponseStream<T>;
  on(type: 'status', handler: (status: Status) => void): ResponseStream<T>;
}
interface RequestStream<T> {
  write(message: T): RequestStream<T>;
  end(): void;
  cancel(): void;
  on(type: 'end', handler: (status?: Status) => void): RequestStream<T>;
  on(type: 'status', handler: (status: Status) => void): RequestStream<T>;
}
interface BidirectionalStream<ReqT, ResT> {
  write(message: ReqT): BidirectionalStream<ReqT, ResT>;
  end(): void;
  cancel(): void;
  on(type: 'data', handler: (message: ResT) => void): BidirectionalStream<ReqT, ResT>;
  on(type: 'end', handler: (status?: Status) => void): BidirectionalStream<ReqT, ResT>;
  on(type: 'status', handler: (status: Status) => void): BidirectionalStream<ReqT, ResT>;
}

export class ServiceDefinitionClient {
  readonly serviceHost: string;

  constructor(serviceHost: string, options?: grpc.RpcOptions);
  geoFixMe(
    requestMessage: geo_me_pb.GeoRequest,
    metadata: grpc.Metadata,
    callback: (error: ServiceError|null, responseMessage: geo_me_pb.GeolocationResult|null) => void
  ): UnaryResponse;
  geoFixMe(
    requestMessage: geo_me_pb.GeoRequest,
    callback: (error: ServiceError|null, responseMessage: geo_me_pb.GeolocationResult|null) => void
  ): UnaryResponse;
}

