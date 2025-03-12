package com.product.exception;

import com.product.viewmodel.errorvm.ErrorVm;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalHandlerException {



    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorVm> NotFoundExceptionHandler(WebRequest webRequest, NotFoundException ex) {
            ErrorVm errorVm = new ErrorVm(HttpStatusCode.valueOf(404).toString(), webRequest.getDescription(false),HttpStatus.NOT_FOUND.getReasonPhrase(),ex.getMessage());
            return new ResponseEntity<>(errorVm, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorVm> BadRequestExceptionHandler(WebRequest webRequest, BadRequestException ex) {
        ErrorVm errorVm = new ErrorVm(HttpStatusCode.valueOf(400).toString(), webRequest.getDescription(false),HttpStatus.BAD_REQUEST.getReasonPhrase(),ex.getMessage());
        return new ResponseEntity<>(errorVm, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorVm> HandlerArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        List<String> errors = methodArgumentNotValidException.getBindingResult().getFieldErrors()
                .stream().map(er -> er.getDefaultMessage()).collect(Collectors.toList());
        ErrorVm errorVm = new ErrorVm(HttpStatusCode.valueOf(400).toString(),HttpStatus.BAD_GATEWAY.getReasonPhrase(),"Request information is not valid",errors);
        return new ResponseEntity<>(errorVm, HttpStatus.BAD_REQUEST);
    }




}
