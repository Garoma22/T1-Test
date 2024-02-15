package ru.galkin.task.exception;
    public class InvalidInputException extends RuntimeException {
        public InvalidInputException(String message) {
            super(message);
        }
    }