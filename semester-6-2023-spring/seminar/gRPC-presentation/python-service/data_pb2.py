# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: data.proto
"""Generated protocol buffer code."""
from google.protobuf.internal import builder as _builder
from google.protobuf import descriptor as _descriptor
from google.protobuf import descriptor_pool as _descriptor_pool
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()




DESCRIPTOR = _descriptor_pool.Default().AddSerializedFile(b'\n\ndata.proto\"\x18\n\x0b\x44\x61taRequest\x12\t\n\x01n\x18\x01 \x01(\x03\")\n\x0c\x44\x61taResponse\x12\x19\n\x05value\x18\x01 \x03(\x0b\x32\n.DataEntry\";\n\tDataEntry\x12\x0c\n\x04time\x18\x01 \x01(\x03\x12\r\n\x05value\x18\x02 \x01(\x01\x12\x11\n\tavailable\x18\x03 \x01(\x08\x32\x37\n\x0b\x44\x61taService\x12(\n\tQueryData\x12\x0c.DataRequest\x1a\r.DataResponseb\x06proto3')

_builder.BuildMessageAndEnumDescriptors(DESCRIPTOR, globals())
_builder.BuildTopDescriptorsAndMessages(DESCRIPTOR, 'data_pb2', globals())
if _descriptor._USE_C_DESCRIPTORS == False:

  DESCRIPTOR._options = None
  _DATAREQUEST._serialized_start=14
  _DATAREQUEST._serialized_end=38
  _DATARESPONSE._serialized_start=40
  _DATARESPONSE._serialized_end=81
  _DATAENTRY._serialized_start=83
  _DATAENTRY._serialized_end=142
  _DATASERVICE._serialized_start=144
  _DATASERVICE._serialized_end=199
# @@protoc_insertion_point(module_scope)
