package application.model;

public class Usuario {
	 private int id;
	    private String nome;
	    private String senha;
	    private String email;
	    private String cpf;
	    private String endereco;
	    private String rg;
	    private String bairro;
	    private String celular;
	    private String cidade;
	    private String telefone;
	    private String login;
	    private String cep;
	    private String estado;

	    // ✅ Construtor completo
	    public Usuario(int id, String nome, String senha, String email, String cpf, String endereco,
	                   String rg, String bairro, String celular, String cidade, String telefone,
	                   String login, String cep, String estado) {
	        this.id = id;
	        this.nome = nome;
	        this.senha = senha;
	        this.email = email;
	        this.cpf = cpf;
	        this.endereco = endereco;
	        this.rg = rg;
	        this.bairro = bairro;
	        this.celular = celular;
	        this.cidade = cidade;
	        this.telefone = telefone;
	        this.login = login;
	        this.cep = cep;
	        this.estado = estado;
	    }

	    // ✅ Construtor sem ID (para cadastro novo)
	    public Usuario(String nome, String senha, String email, String cpf, String endereco,
	                   String rg, String bairro, String celular, String cidade, String telefone,
	                   String login, String cep, String estado) {
	        this.nome = nome;
	        this.senha = senha;
	        this.email = email;
	        this.cpf = cpf;
	        this.endereco = endereco;
	        this.rg = rg;
	        this.bairro = bairro;
	        this.celular = celular;
	        this.cidade = cidade;
	        this.telefone = telefone;
	        this.login = login;
	        this.cep = cep;
	        this.estado = estado;
	    }

	    // ✅ Getters e Setters
	    public int getId() { return id; }
	    public void setId(int id) { this.id = id; }

	    public String getNome() { return nome; }
	    public void setNome(String nome) { this.nome = nome; }

	    public String getSenha() { return senha; }
	    public void setSenha(String senha) { this.senha = senha; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

	    public String getCpf() { return cpf; }
	    public void setCpf(String cpf) { this.cpf = cpf; }

	    public String getEndereco() { return endereco; }
	    public void setEndereco(String endereco) { this.endereco = endereco; }

	    public String getRg() { return rg; }
	    public void setRg(String rg) { this.rg = rg; }

	    public String getBairro() { return bairro; }
	    public void setBairro(String bairro) { this.bairro = bairro; }

	    public String getCelular() { return celular; }
	    public void setCelular(String celular) { this.celular = celular; }

	    public String getCidade() { return cidade; }
	    public void setCidade(String cidade) { this.cidade = cidade; }

	    public String getTelefone() { return telefone; }
	    public void setTelefone(String telefone) { this.telefone = telefone; }

	    public String getLogin() { return login; }
	    public void setLogin(String login) { this.login = login; }

	    public String getCep() { return cep; }
	    public void setCep(String cep) { this.cep = cep; }

	    public String getEstado() { return estado; }
	    public void setEstado(String estado) { this.estado = estado; }
}
