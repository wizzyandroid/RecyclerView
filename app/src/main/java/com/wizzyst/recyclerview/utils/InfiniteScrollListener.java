package com.wizzyst.recyclerview.utils;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/*=============================*/
/*            AUTHOR           */
/*          JULIAN NR          */
/* juliannoorrizani@gmail.com  */
/*         25 Nov 2019         */
/*=============================*/

public abstract class InfiniteScrollListener extends RecyclerView.OnScrollListener {
    private int previousTotal = 0;
    private boolean loading = true;

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        int visibleItemCount = recyclerView.getChildCount();
        int totalItemCount = recyclerView.getLayoutManager().getItemCount();
        int firstVisibleItem = ((LinearLayoutManager)recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
        if (loading){
            if (totalItemCount > previousTotal){
                loading = false;
                previousTotal = totalItemCount;
            }
        }

        int visibleThreshold = 5;
        if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold) && canLoadMore()){
            onLoadMore();
            loading = true;
        }
    }

    public abstract boolean canLoadMore();

    public abstract void onLoadMore();
}
