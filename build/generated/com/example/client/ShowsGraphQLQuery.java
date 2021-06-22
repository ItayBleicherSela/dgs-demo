package com.example.client;

import com.netflix.graphql.dgs.client.codegen.GraphQLQuery;
import java.lang.Override;
import java.lang.String;

public class ShowsGraphQLQuery extends GraphQLQuery {
  public ShowsGraphQLQuery(String titleFilter) {
    super("query");
    if (titleFilter != null) {
        getInput().put("titleFilter", titleFilter);
    }
  }

  public ShowsGraphQLQuery() {
    super("query");
  }

  @Override
  public String getOperationName() {
    return "shows";
  }

  public static Builder newRequest() {
    return new Builder();
  }

  public static class Builder {
    private String titleFilter;

    public ShowsGraphQLQuery build() {
      return new ShowsGraphQLQuery(titleFilter);
    }

    public Builder titleFilter(String titleFilter) {
      this.titleFilter = titleFilter;
      return this;
    }
  }
}
