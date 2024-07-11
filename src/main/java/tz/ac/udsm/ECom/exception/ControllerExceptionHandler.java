package tz.ac.udsm.ECom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import tz.ac.udsm.ECom.dto.MessageDTO;

import javax.naming.OperationNotSupportedException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = DataNotFoundException.class)
    public ResponseEntity<MessageDTO> handleDataNotFoundException(DataNotFoundException exception){
        MessageDTO messageDTO =new MessageDTO();
        messageDTO.setMessage(exception.getMessage());
        messageDTO.setStatus(false);
        messageDTO.setStatus(false);
        return new ResponseEntity<>(messageDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = OperationNotSupportedException.class)
    public ResponseEntity<MessageDTO> handleOperationNotSupportedException(OperationNotSupportedException exception){
        MessageDTO messageDTO =new MessageDTO();
        messageDTO.setMessage(exception.getMessage());
        messageDTO.setStatus(false);
        messageDTO.setStatus(false);
        return new ResponseEntity<>(messageDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<MessageDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
        MessageDTO messageDTO =new MessageDTO();
        List<String> errors = exception.getBindingResult().getFieldErrors()
                .stream().map(fieldError -> fieldError.getDefaultMessage()).collect(Collectors.toList());
        messageDTO.setMessage(errors);
        messageDTO.setStatus(false);
        return new ResponseEntity<>(messageDTO, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(value = Exception.class)
//    public ResponseEntity<MessageDTO> handleException(Exception exception){
//        MessageDTO messageDTO =new MessageDTO();
//        messageDTO.setMessage(exception.getMessage());
//        messageDTO.setStatus(false);
//        messageDTO.setStatus(false);
//        return new ResponseEntity<>(messageDTO, HttpStatus.BAD_GATEWAY);
//    }

}
