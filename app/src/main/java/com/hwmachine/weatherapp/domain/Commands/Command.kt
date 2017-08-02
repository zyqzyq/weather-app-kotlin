package com.hwmachine.weatherapp.domain.Commands

public interface Command<T>{
    fun execute(): T
}