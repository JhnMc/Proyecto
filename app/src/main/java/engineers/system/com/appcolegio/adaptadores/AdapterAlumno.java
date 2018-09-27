package engineers.system.com.appcolegio.adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import engineers.system.com.appcolegio.R;
import engineers.system.com.appcolegio.modelo.Alumno;

public class AdapterAlumno extends RecyclerView.Adapter<AdapterAlumno.ViewHolderAlumnos>
                            implements View.OnClickListener{

    ArrayList<Alumno> alumnoArrayList;
    private View.OnClickListener clickListener;

    public AdapterAlumno(ArrayList<Alumno> alumnoArrayList) {
        this.alumnoArrayList = alumnoArrayList;
    }

    @NonNull
    @Override
    public AdapterAlumno.ViewHolderAlumnos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.targeta_alumno,null,false);

        vista.setOnClickListener(this);
        return new ViewHolderAlumnos(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAlumno.ViewHolderAlumnos holder, int position) {
        holder.asignarAlumnos(alumnoArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return alumnoArrayList.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.clickListener = listener;
    }

    @Override
    public void onClick(View v) {
        if(clickListener !=null){
            clickListener.onClick(v);
        }

    }

    public class ViewHolderAlumnos extends RecyclerView.ViewHolder {
        TextView txtNombre, txtApellido, txtDireccion, txtSexo, txtFNacimiento;
        public ViewHolderAlumnos(View itemView) {
            super(itemView);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtApellido = itemView.findViewById(R.id.txtApellido);
            txtDireccion = itemView.findViewById(R.id.txtDireccion);
            txtSexo = itemView.findViewById(R.id.txtSexo);
            txtFNacimiento = itemView.findViewById(R.id.txtFNacimiento);
        }

        public void asignarAlumnos(Alumno alumnos) {
            txtNombre.setText(alumnos.getNombre());
            txtApellido.setText(alumnos.getApellido());
            txtDireccion.setText(alumnos.getDireccion());
            txtFNacimiento.setText(alumnos.getfNacimiento());
            txtSexo.setText(alumnos.getSexo());
        }
    }


}
