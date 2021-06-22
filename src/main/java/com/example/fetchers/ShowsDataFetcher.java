package com.example.fetchers;

import com.example.consts.DgsConstants;
import com.example.types.Show;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.InputArgument;
import graphql.schema.DataFetchingEnvironment;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@DgsComponent
public class ShowsDataFetcher {
    @DgsData(
            parentType = DgsConstants.QUERY_TYPE,
            field = DgsConstants.QUERY.Shows
    )
    public CompletableFuture<List<Show>> getShows(@InputArgument String titleFilter, DataFetchingEnvironment dataFetchingEnvironment) {
        return CompletableFuture.completedFuture(List.of(Show.newBuilder().title(titleFilter).build()));
    }

    @DgsData(parentType = DgsConstants.SHOW.TYPE_NAME, field = DgsConstants.SHOW.ReleaseYear)
    public CompletableFuture<Integer> showReleaseYear(DataFetchingEnvironment dataFetchingEnvironment) {
        Show source = dataFetchingEnvironment.getSource();
        if(source.getTitle().equals("Bleicher")){
            return CompletableFuture.completedFuture(420);
        }
        return CompletableFuture.completedFuture(0);
    }
}
