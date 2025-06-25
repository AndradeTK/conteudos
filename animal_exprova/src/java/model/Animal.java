package model;

/**
 *
 * @author Bryan
 */
public class Animal {
    private int codigo;
    private String nome;
    private float peso;

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     * @throws java.lang.Exception
     */
    public void setCodigo(int codigo) throws Exception {
        if (codigo > 0) {  // Verifica se o código é maior que 0
            this.codigo = codigo;
        } else {
            throw new Exception("O código deve ser maior que 0");
        }
    }

    /**
     * @param codigo Código recebido como String
     * @throws java.lang.Exception
     */
    public void setCodigo(String codigo) throws Exception {
        if (Integer.parseInt(codigo) > 0) {  // Tenta converter para int e valida
            this.setCodigo(Integer.parseInt(codigo));  // Chama o método que já valida o código
        } else {
            throw new Exception("O código deve ser maior que 0");
        }
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     * @throws java.lang.Exception
     */
    public void setNome(String nome) throws Exception {
        if (nome.trim().length() > 1) {  // Verifica se o nome tem pelo menos 2 caracteres
            this.nome = nome;
        } else {
            throw new Exception("Nome inválido");
        }
    }

    /**
     * @return the peso
     */
    public float getPeso() {
        return peso;
    }

    /**
     * @param peso o peso para definir
     * @throws java.lang.Exception
     */
    public void setPeso(float peso) throws Exception {
        if (peso > 0 && peso < 1000) {  // Verifica se o peso está entre 0 e 1000
            this.peso = peso;
        } else {
            throw new Exception("Peso deve ser entre 0 e 1000");
        }
    }

    /**
     * @param peso Peso recebido como String
     * @throws java.lang.Exception
     */
    public void setPeso(String peso) throws Exception {
        if (Float.parseFloat(peso) > 0 && Float.parseFloat(peso) < 1000) {  // Valida peso dentro do intervalo
            this.setPeso(Float.parseFloat(peso));  // Chama o método que já valida o peso
        } else {
            throw new Exception("Peso deve ser entre 0 e 1000");
        }
    }
}
