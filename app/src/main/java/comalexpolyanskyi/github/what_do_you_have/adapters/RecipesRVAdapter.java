package comalexpolyanskyi.github.what_do_you_have.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import comalexpolyanskyi.github.what_do_you_have.R;
import comalexpolyanskyi.github.what_do_you_have.dataModels.RecipesModel.DummyItem;
import comalexpolyanskyi.github.what_do_you_have.fragments.RecipesFragment;


public class RecipesRVAdapter extends RecyclerView.Adapter<RecipesRVAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final RecipesFragment.OnListFragmentInteractionListener mListener;

    public RecipesRVAdapter(List<DummyItem> items, RecipesFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_recipes_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setTag(mValues.get(position).id);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    v.setTag(holder.mItem);
                    mListener.onRecipesFragmentInteraction(v);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
