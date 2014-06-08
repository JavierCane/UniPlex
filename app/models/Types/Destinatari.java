package models.types;

import com.avaje.ebean.annotation.EnumValue;

public enum Destinatari {
    @EnumValue("Indiferent")
    INDIFERENT( 1, "Indiferent" ),

    @EnumValue("Estudiants")
    ESTUDIANTS( 2, "Estudiants" ),

    @EnumValue("AcabatsDeTitular")
    ACABATS_DE_TITULAR( 3, "Acabats de titular" ),

    @EnumValue("TitulatsAmbExperiencia")
    TITULATS_AMB_EXPERIENCIA( 4, "Titulats amb experiència" );

    private final Integer id;
    private final String nom;

    Destinatari( final Integer id, final String nom ) {
        this.id = id;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return this.nom;
    }
}