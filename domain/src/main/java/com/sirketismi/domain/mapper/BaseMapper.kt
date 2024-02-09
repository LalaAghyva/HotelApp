package com.sirketismi.domain.mapper

interface BaseMapper<Input, Output> {

    fun map(input : Input) : Output
}