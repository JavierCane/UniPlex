package models.types;

import com.avaje.ebean.annotation.EnumValue;

public enum JornadaLaboral {
    @EnumValue( "Indiferent" )
    INDIFERENT( 1, "Indiferent" ),

    @EnumValue( "Completa" )
    COMPLETA( 2, "Completa" ),

    @EnumValue( "Mitja" )
    MITJA( 3, "Mitja" );

    private final Integer id;
    private final String nom;

    JornadaLaboral( final Integer id, final String nom ) {
        this.id = id;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return this.nom;
    }
}
