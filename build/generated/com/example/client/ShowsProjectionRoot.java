package com.example.client;

import com.netflix.graphql.dgs.client.codegen.BaseProjectionNode;

public class ShowsProjectionRoot extends BaseProjectionNode {
  public ShowsProjectionRoot title() {
    getFields().put("title", null);
    return this;
  }

  public ShowsProjectionRoot releaseYear() {
    getFields().put("releaseYear", null);
    return this;
  }
}
