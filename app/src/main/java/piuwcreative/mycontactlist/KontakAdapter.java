package piuwcreative.mycontactlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class KontakAdapter extends RecyclerView.Adapter<KontakAdapter.KontakViewHolder> {
    private Context context;
    private ArrayList<Kontak> kontaks;

    public KontakAdapter(Context context) {
        this.context = context;
    }

    public void setKontaks(ArrayList<Kontak> kontaks) {
        this.kontaks = kontaks;
    }

    @NonNull
    @Override
    public KontakAdapter.KontakViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_kontak, parent, false);

        return new KontakAdapter.KontakViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KontakAdapter.KontakViewHolder holder, int position) {
            holder.name.setText(kontaks.get(position).getName());
            holder.phone.setText(kontaks.get(position).getPhone());
    }

    @Override
    public int getItemCount() {
        return kontaks.size();
    }

    public class KontakViewHolder extends RecyclerView.ViewHolder {
        private TextView name, phone;
        public KontakViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            phone = itemView.findViewById(R.id.tv_phone);
        }
    }
}
