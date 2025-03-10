package com.develogical;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class QueryProcessorTest {

  QueryProcessor queryProcessor = new QueryProcessor();

  @Test
  public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
    assertThat(queryProcessor.process("test"), is(""));
  }

  @Test
  public void knowsAboutShakespeare() throws Exception {
    assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
  }

  @Test 
  public void knowsName() {
    assertThat(queryProcessor.process("What is your name?"), containsString("Tushita"));
  }

  @Test 
  public void knowsMaxNo() {
    assertThat(queryProcessor.process("Which of the following numbers is the largest: 65, 4, 86?"), containsString("86"));
  }

  @Test 
  public void knowsPlus() {
    assertThat(queryProcessor.process("What is 32 plus 59?"), containsString("91"));
  }

  @Test 
  public void knowsMultiply() {
    assertThat(queryProcessor.process("What is 3 multiplied by 6?"), containsString("18"));
  }
}
