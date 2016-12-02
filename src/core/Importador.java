package core;

import java.io.IOException;
import java.util.ArrayList;

public interface Importador {
	public abstract ArrayList<Caso> importarCasos() throws IOException;
}
