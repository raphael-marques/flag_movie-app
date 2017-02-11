package flag.pt.moviesapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import flag.pt.moviesapp.R;
import flag.pt.moviesapp.http.entities.ResultPopularTvShow;
import flag.pt.moviesapp.screens.DetailTvShowScreen;

/**
 * Created by Marina on 29/01/2017.
 */

public class ListPopularTvShowAdapter extends ArrayAdapter<ResultPopularTvShow> {

    private static final String TAG = ListPopularTvShowAdapter.class.getSimpleName();

    public ListPopularTvShowAdapter(Context context, List<ResultPopularTvShow> tvShows) {
        super( context, 0, tvShows );
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = convertView;
        TvShowHolder holder;
        final ResultPopularTvShow tvShow = getItem( position );

        if (v == null) {
            v = LayoutInflater.from( getContext() ).inflate( R.layout.popular_tv_show_item, null );
            holder = new TvShowHolder();
            holder.tvShowCardView = (CardView) v.findViewById(R.id.popular_tv_show_item_cardview);
            holder.tvShowItem = (TextView) v.findViewById( R.id.popular_tv_show_item );
            holder.tvShowItemAirDate = (TextView) v.findViewById(R.id.popular_tv_show_item_date);
            v.setTag( holder );
        } else {
            holder = (TvShowHolder) v.getTag();
        }

        holder.tvShowItem.setText( tvShow.getName() );
        holder.tvShowItemAirDate.setText(tvShow.getFirstAirDate());
        holder.tvShowCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TvShowDetailIntent = new Intent(getContext(), DetailTvShowScreen.class );
                TvShowDetailIntent.putExtra(DetailTvShowScreen.TV_SHOW_DETAILS, tvShow);
                getContext().startActivity(TvShowDetailIntent);
            }
        });
        return v;
    }

    private class TvShowHolder {
        TextView tvShowItem;
        TextView tvShowItemAirDate;
        CardView tvShowCardView;
    }
}
