package com.pablodomingos.classes.rps.builders;


import com.pablodomingos.classes.rps.RpsPrestador;
import com.pablodomingos.validadores.ValidadorString;

public class PrestadorBuilder{

  private String cnpj;
  private String inscricaoMunicipal;
  
  public PrestadorBuilder(String cnpj) {
    if (cnpj == null) {
      throw new IllegalArgumentException("CNPJ não pode ser nulo");
    }
    cnpj = cnpj.replaceAll("[^0-9]", "");
    if (cnpj.length() == 14){
      this.cnpj = cnpj;
    }else {
      throw new IllegalArgumentException("CNPJ deve ter tamanho igual a 14");
    }
    this.cnpj = cnpj;
  }

  public PrestadorBuilder comInscricaoMunicipal(String inscricaoMunicipal) {
    this.inscricaoMunicipal = ValidadorString.comTamanhoMaximoEMinimo(15, 1, inscricaoMunicipal, "Inscricao municipal");
    return this;
  }
  
  public RpsPrestador build() {
    return new RpsPrestador(this);
  }

  public String getCnpj() {
    return cnpj;
  }

  public String getInscricaoMunicipal() {
    return inscricaoMunicipal;
  }

  
}
