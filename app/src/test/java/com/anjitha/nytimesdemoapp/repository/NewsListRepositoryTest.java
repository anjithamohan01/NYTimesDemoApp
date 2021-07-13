package com.anjitha.nytimesdemoapp.repository;


import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class NewsListRepositoryTest extends TestCase {

    @Spy
    NewsListRepository repository;

    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        super.setUp();
    }

   @Test
    public void testGetNewsList() {
         doReturn(repository.getNewsList()).when(repository).getNewsList();
    }
}