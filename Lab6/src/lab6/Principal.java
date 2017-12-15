package lab6;

/* Aluno : Herculys Sabino */

import lab6.CD;
import lab6.MinhaCDTeca;

public class Principal {
    
    public static void main(String[] args) throws Exception
    {
        CD album = new CD(" American Idiot ", "Green Day", 11);
        album.adicionaMusica("American Idiot");
        album.adicionaMusica("Jesus of Suburbia");
        album.adicionaMusica("Boulevard of Broken Dreams");
        album.adicionaMusica("Saint Jimmy");
        album.setmusicaM("American Idiot");
        //System.out.println(album.toString());
        MinhaCDTeca cdTeca = new MinhaCDTeca();      
        CD cdEvanescence = new CD("Fallen", "Evanescence", 12);
        CD cdMetallica = new CD("The Black Album ", "Metallica", 14);
		CD cdSlipknot = new CD("iowa", "Slipknot", 8);
        cdTeca.adicionarCD(cdEvanescence);
        cdTeca.adicionarCD(cdMetallica);
        cdTeca.adicionarCD(cdSlipknot);
       
        System.out.print("CDs: ");
        System.out.print(cdTeca.numeroDeCDs() + "\n");
        System.out.print(cdTeca.toString());
          
    }
}