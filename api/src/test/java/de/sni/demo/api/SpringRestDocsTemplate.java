package de.sni.demo.api;

import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor;
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor;
import org.springframework.restdocs.snippet.Snippet;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;

public class SpringRestDocsTemplate
{

    public static RestDocumentationResultHandler template(
            final String className,
            final String methodName,
            final OperationRequestPreprocessor requestPreprocessor,
            final OperationResponsePreprocessor responsePreprocessor,
            final Snippet... snippets)
    {


        return document(className + "/" + methodName,
                        requestPreprocessor,
                        responsePreprocessor,
                        snippets);
    }
    public static RestDocumentationResultHandler template(
            final String className,
            final String methodName)
    {

        return document(className + "/" + methodName,
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()));
    }
}
