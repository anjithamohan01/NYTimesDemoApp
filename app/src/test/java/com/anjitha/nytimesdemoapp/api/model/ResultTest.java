package com.anjitha.nytimesdemoapp.api.model;

import com.anjitha.nytimesdemoapp.models.Medium;
import com.anjitha.nytimesdemoapp.models.Result;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class ResultTest {

    private final String title = "Testing Title";
    private final String section = "Testing section";
    private final String byline = "Testing byline";
    private final String publishedDate = "01-01-2021";
    private final List<Medium> mediaEntityList = new ArrayList<>();

    @Mock
    Result newsItem;
    @Mock
    List<Medium> mediaList;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Mockito.when(newsItem.getTitle()).thenReturn(title);
        Mockito.when(newsItem.getSection()).thenReturn(section);
        Mockito.when(newsItem.getByline()).thenReturn(byline);
        Mockito.when(newsItem.getPublishedDate()).thenReturn(publishedDate);
        Mockito.when(newsItem.getMedia()).thenReturn(mediaEntityList);
    }

    @Test
    public void testNewsTitle(){
        Mockito.when(newsItem.getTitle()).thenReturn(title);
        Assert.assertEquals("Testing Title",newsItem.getTitle());
    }

    @Test
    public void testNewsSection(){
        Mockito.when(newsItem.getSection()).thenReturn(section);
        Assert.assertEquals("Testing section",newsItem.getSection());
    }


    @Test
    public void testNewsByline(){
        Mockito.when(newsItem.getByline()).thenReturn(byline);
        Assert.assertEquals("Testing byline",newsItem.getByline());
    }

    @Test
    public void testNewsDate(){
        Mockito.when(newsItem.getPublishedDate()).thenReturn(publishedDate);
        Assert.assertEquals("29-01-2019",newsItem.getPublishedDate());
    }


    @Test
    public void testNewsMediaEntitiy(){
        Mockito.when(newsItem.getMedia()).thenReturn(mediaEntityList);
        Assert.assertEquals(new ArrayList<>(),newsItem.getMedia());
    }



    @Test
    public void testNewsTitleIncorrect(){
        Mockito.when(newsItem.getTitle()).thenReturn(title);
        Assert.assertNotEquals("Title",newsItem.getTitle());
    }



    @Test
    public void testNewsBylineIncorrect(){
        Mockito.when(newsItem.getByline()).thenReturn(byline);
        Assert.assertNotEquals("byline",newsItem.getByline());
    }

    @Test
    public void testNewsDateIncorrect(){
        Mockito.when(newsItem.getPublishedDate()).thenReturn(publishedDate);
        Assert.assertNotEquals("01-01-2021",newsItem.getPublishedDate());
    }


    @Test
    public void testNewsMediaEntitiyIncorrect(){
        Mockito.when(newsItem.getMedia()).thenReturn(mediaEntityList);
        Assert.assertNotEquals("",newsItem.getMedia());
    }


    @After
    public void tearDown() throws Exception {
        newsItem =null;
        mediaList = null;
    }
}
