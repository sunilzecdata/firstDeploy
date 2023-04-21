//package com.example.custom.exception;
//
//import org.hibernate.exception.ConstraintViolationException;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.http.converter.HttpMessageNotWritableException;
//import org.springframework.web.HttpMediaTypeNotSupportedException;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.MissingServletRequestParameterException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.ServletWebRequest;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
//import org.springframework.web.servlet.NoHandlerFoundException;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//import jakarta.persistence.EntityNotFoundException;
//import lombok.extern.log4j.Log4j2;
//
//@ControllerAdvice
//@Log4j2(topic = "rest_controller_exception")
//public class RestExceptionHandler extends ResponseEntityExceptionHandler {
//
//    /**
//     * Handle MissingServletRequestParameterException. Triggered when a 'required' request parameter is missing.
//     *
//     * @param ex      MissingServletRequestParameterException
//     * @param headers HttpHeaders
//     * @param status  HttpStatus
//     * @param request WebRequest
//     * @return the ApiError object
//     */
//   
//    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
//                                                                          HttpHeaders headers, HttpStatus status, WebRequest request) {
//        String error = ex.getParameterName() + " parameter is missing";
//        logger.error(ex.getMessage());
//        return buildResponseEntity(new ApiError(BAD_REQUEST, error));
//    }
//
//
//    /**
//     * Handle HttpMediaTypeNotSupportedException. This one triggers when JSON is invalid as well.
//     *
//     * @param ex      HttpMediaTypeNotSupportedException
//     * @param headers HttpHeaders
//     * @param status  HttpStatus
//     * @param request WebRequest
//     * @return the ApiError object
//     */
//    
//    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
//            HttpMediaTypeNotSupportedException ex,
//            HttpHeaders headers,
//            HttpStatus status,
//            WebRequest request) {
//        StringBuilder builder = new StringBuilder();
//        builder.append(ex.getContentType());
//        builder.append(" media type is not supported. Supported media types are ");
//        ex.getSupportedMediaTypes().forEach(t -> builder.append(t).append(", "));
//        logger.error(ex.getMessage());
//        return buildResponseEntity(new ApiError(HttpStatus.UNSUPPORTED_MEDIA_TYPE, builder.substring(0, builder.length() - 2)));
//    }
//
//    /**
//     * Handle MethodArgumentNotValidException. Triggered when an object fails @Valid validation.
//     *
//     * @param ex      the MethodArgumentNotValidException that is thrown when @Valid validation fails
//     * @param headers HttpHeaders
//     * @param status  HttpStatus
//     * @param request WebRequest
//     * @return the ApiError object
//     */
//    
//    protected ResponseEntity<Object> handleMethodArgumentNotValid(
//            MethodArgumentNotValidException ex,
//            HttpHeaders headers,
//            HttpStatus status,
//            WebRequest request) {
//        ApiError apiError = new ApiError(BAD_REQUEST);
//        apiError.setMessage("Validation error");
//        apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
//        apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
//        logger.error(ex.getMessage());
//        return buildResponseEntity(apiError);
//    }
//
//    /**
//     * Handles javax.validation.ConstraintViolationException. Thrown when @Validated fails.
//     *
//     * @param ex the ConstraintViolationException
//     * @return the ApiError object
//     */
//    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
//    protected ResponseEntity<Object> handleConstraintViolation(
//            javax.validation.ConstraintViolationException ex) {
//        ApiError apiError = new ApiError(BAD_REQUEST);
//        apiError.setMessage("Validation error");
//        apiError.addValidationErrors(ex.getConstraintViolations());
//        logger.error(ex.getMessage());
//        return buildResponseEntity(apiError);
//    }
//
//    /**
//     * Handles EntityNotFoundException. Created to encapsulate errors with more detail than javax.persistence.EntityNotFoundException.
//     *
//     * @param ex the EntityNotFoundException
//     * @return the ApiError object
//     */
//    @ExceptionHandler(EntityNotFoundException.class)
//    protected ResponseEntity<Object> handleEntityNotFound(
//            EntityNotFoundException ex) {
//        ApiError apiError = new ApiError(NOT_FOUND);
//        apiError.setMessage(ex.getMessage());
//        logger.error(ex.getMessage());
//        return buildResponseEntity(apiError);
//    }
//
//    /**
//     * Handle HttpMessageNotReadableException. Happens when request JSON is malformed.
//     *
//     * @param ex      HttpMessageNotReadableException
//     * @param headers HttpHeaders
//     * @param status  HttpStatus
//     * @param request WebRequest
//     * @return the ApiError object
//     */
//    
//    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        ServletWebRequest servletWebRequest = (ServletWebRequest) request;
//        log.info("{} to {}", servletWebRequest.getHttpMethod(), servletWebRequest.getRequest().getServletPath());
//        String error = "Malformed JSON request";
//        logger.error(ex.getMessage());
//        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error));
//    }
//
//    /**
//     * Handle HttpMessageNotWritableException.
//     *
//     * @param ex      HttpMessageNotWritableException
//     * @param headers HttpHeaders
//     * @param status  HttpStatus
//     * @param request WebRequest
//     * @return the ApiError object
//     */
//    
//    protected ResponseEntity<Object> handleHttpMessageNotWritable(HttpMessageNotWritableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        String error = "Error writing JSON output";
//        logger.error(ex.getMessage());
//        return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, error));
//    }
//
//    /**
//     * Handle NoHandlerFoundException.
//     *
//     * @param ex
//     * @param headers
//     * @param status
//     * @param request
//     * @return
//     */
//  
//    protected ResponseEntity<Object> handleNoHandlerFoundException(
//            NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        logger.error(ex.getMessage());
//        ApiError apiError = new ApiError(BAD_REQUEST);
//        apiError.setMessage(String.format("Could not find the %s method for URL %s",
//                ex.getHttpMethod(), ex.getRequestURL()));
//        apiError.setDebugMessage(ex.getMessage());
//        return buildResponseEntity(apiError);
//    }
//
//    /**
//     * Handle javax.persistence.EntityNotFoundException
//     */
//    @ExceptionHandler(javax.persistence.EntityNotFoundException.class)
//    protected ResponseEntity<Object> handleEntityNotFound(javax.persistence.EntityNotFoundException ex) {
//        logger.error(ex.getMessage());
//        return buildResponseEntity(new ApiError(HttpStatus.NOT_FOUND));
//    }
//
//    /**
//     * Handle DataIntegrityViolationException, inspects the cause for different DB causes.
//     *
//     * @param ex the DataIntegrityViolationException
//     * @return the ApiError object
//     */
//    @ExceptionHandler(DataIntegrityViolationException.class)
//    protected ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex,
//                                                                  WebRequest request) {
//        logger.error(ex.getMessage());
//        if (ex.getCause() instanceof ConstraintViolationException) {
//            return buildResponseEntity(new ApiError(HttpStatus.CONFLICT, "Database error"));
//        }
//        return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR));
//    }
//
//    /**
//     * Handle Exception, handle generic Exception.class
//     *
//     * @param ex the Exception
//     * @return the ApiError object
//     */
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    protected ResponseEntity<Object> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
//                                                                      WebRequest request) {
//        ApiError apiError = new ApiError(BAD_REQUEST);
//        String simpleName;
//        simpleName = ex.getRequiredType() == null ? "" : ex.getRequiredType().getSimpleName();
//        apiError.setMessage(String.format("The parameter '%s' of value '%s' could not be converted to type '%s'",
//                ex.getName(), ex.getValue(), simpleName));
//        apiError.setDebugMessage(ex.getMessage());
//        logger.error(ex.getMessage());
//        return buildResponseEntity(apiError);
//    }
//
//    @ExceptionHandler(IncorrectInputException.class)
//    protected ResponseEntity<Object> handleGenericException(IncorrectInputException ex, WebRequest request) {
//        ApiError apiError = new ApiError(BAD_REQUEST);
//        apiError.setMessage(ex.getMessage());
//        apiError.setDebugMessage(ex.getMessage());
//        logger.error(ex.getMessage());
//        return buildResponseEntity(apiError);
//    }
//
//    @ExceptionHandler(NotFoundException.class)
//    protected ResponseEntity<Object> handleGenericException(NotFoundException ex, WebRequest request) {
//        ApiError apiError = new ApiError(OK);
//        apiError.setMessage(ex.getMessage());
//        apiError.setDebugMessage(ex.getMessage());
//        logger.error(ex.getMessage());
//        return buildResponseEntity(apiError);
//    }
//
//    @ExceptionHandler(AlreadyPresentException.class)
//    protected ResponseEntity<Object> handleGenericException(AlreadyPresentException ex, WebRequest request) {
//        ApiError apiError = new ApiError(OK);
//        apiError.setMessage(ex.getMessage());
//        apiError.setDebugMessage(ex.getMessage());
//        logger.error(ex.getMessage());
//        return buildResponseEntity(apiError);
//    }
//
//    @ExceptionHandler(Exception.class)
//    protected ResponseEntity<Object> handleGenericException(Exception ex, WebRequest request) {
//        ApiError apiError = new ApiError(BAD_REQUEST);
//        apiError.setMessage(ex.getMessage());
//        apiError.setDebugMessage(ex.getMessage());
//        logger.error(ex.getMessage());
//        return buildResponseEntity(apiError);
//    }
//
//    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
//        logger.error(apiError.getMessage());
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        return new ResponseEntity<>(apiError, headers, apiError.getStatus());
//    }
//
//}