package gerapp.dao.montador;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import gerapp.modelo.*;


public  class RegraColecaoMontadorAgrupado   implements MontadorDaoI { 

	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaRegraColecao();
		return extraiRegistro(resultadoLista, objeto, 1);
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  int pos )  throws  DaoException{
		DCIObjetoDominio objeto;
		objeto = FabricaVo.criaRegraColecao();
		return extraiRegistro(resultadoLista, objeto, pos );
	}


	public  DCIObjetoDominio extraiRegistro( ResultadoLista resultadoLista  ,  DCIObjetoDominio entrada  ,  int pos )  throws  DaoException{
		RegraColecao objeto;
		objeto = (RegraColecao)entrada;
		objeto.setIdRegraColecao(resultadoLista.getInt(pos++));
		objeto.setNome(resultadoLista.getString(pos++));
		objeto.setDescricao(resultadoLista.getString(pos++));
		objeto.setRetornaColecao(resultadoLista.getLogicoConvertido(pos++));
		objeto.setRecebeColecao(resultadoLista.getLogicoConvertido(pos++));
		objeto.setAtivoJava(resultadoLista.getLogicoConvertido(pos++));
		objeto.setAtivoCpp(resultadoLista.getLogicoConvertido(pos++));
		objeto.setAtivoFlex(resultadoLista.getLogicoConvertido(pos++));
		objeto.setAtivoCs(resultadoLista.getLogicoConvertido(pos++));
		objeto.setIdEntidade(resultadoLista.getInt(pos++));
     MontadorDaoI montadorAgrupamento;
		montadorAgrupamento =  new EntidadeMontador();
		objeto.setEntidade ((Entidade)montadorAgrupamento.extraiRegistro(resultadoLista,pos));
		pos += montadorAgrupamento.quantidadeCampos();
		return objeto;
	}
	public  int quantidadeCampos() {
     int conta;
		conta = 10;
     MontadorDaoI montadorAgrupamento;
		montadorAgrupamento =  new EntidadeMontador();
		conta += montadorAgrupamento.quantidadeCampos();
		return conta;
	}

}
