package com.lambdaschool.sampleemps.controllers;

import com.lambdaschool.sampleemps.models.IssPosition;
import com.lambdaschool.sampleemps.models.IssPositionReturnData;
import com.lambdaschool.sampleemps.models.Translation;
import com.lambdaschool.sampleemps.models.TranslationContents;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@RestController
@RequestMapping("/otherapis") // optional
public class OtherApis
{
    /*
     * Creates the object that is needed to do a client side Rest API call.
     * We are the client getting data from a remote API.
     * We can share this template among endpoints
     */
    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping(value = "/isspositions")
    public ResponseEntity<?> listIssPositions()
    {
        // we need to tell our RestTemplate what format to expect
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        // a couple of common formats
        // converter.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_HTML));
        // converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        // or we can accept all formats! Easiest but least secure
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        restTemplate.getMessageConverters()
                .add(converter);

        // create the url to access the API
        String requestURL = "http://api.open-notify.org/iss-now.json";
        // create the responseType expected. Notice the IssPositionReturnData is the data type we are expecting back from the API!
        ParameterizedTypeReference<IssPositionReturnData> responseType = new ParameterizedTypeReference<>()
        {
        };

        // create the response entity. do the get and get back information
        ResponseEntity<IssPositionReturnData> responseEntity = restTemplate.exchange(requestURL,
                HttpMethod.GET,
                null,
                responseType);
        // we want to return the Iss_position data. From the data that gets returned in the body,
        // get the Iss_position data only and return it.
        // putting the data into its own object first, prevents the data from being reported to client inside of
        // an embedded. So the response will look more like our clients are use to!
        IssPosition ourIssPosition = responseEntity.getBody()
                .getIss_position();
        return new ResponseEntity<>(ourIssPosition,
                HttpStatus.OK);
    }

    @GetMapping(value = "/klingon/{englishText}")
    public ResponseEntity<?> getTranslation(
            @PathVariable
                    String englishText)
    {
        // we need to tell our RestTemplate what format to expect
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        // a couple of common formats
        // converter.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_HTML));
        // converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        // or we can accept all formats! Easiest but least secure
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        restTemplate.getMessageConverters()
                .add(converter);

        // create the url to access the API including adding the path variable
        String requestURL = "https://api.funtranslations.com/translate/klingon.json?text=" + englishText;
        // create the responseType expected. Notice the Translation is the data type we are expecting back from the API!
        ParameterizedTypeReference<Translation> responseType = new ParameterizedTypeReference<>()
        {
        };

        // create the response entity. do the get and get back information
        ResponseEntity<Translation> responseEntity = restTemplate.exchange(requestURL,
                HttpMethod.GET,
                null,
                responseType);
        // we want to return the contents of the translation data. From the data that gets returned in the body,
        // get the contents data only and return it.
        // putting the data into its own object first, prevents the data from being reported to client inside of
        // an embedded. So the response will look more like our clients are use to!
        TranslationContents ourTranslation = responseEntity.getBody()
                .getContents();
        return new ResponseEntity<>(ourTranslation,
                HttpStatus.OK);
    }
}
