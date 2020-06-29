/**
 * FilmDAO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package models;

public interface FilmDAO extends java.rmi.Remote {
    public boolean updateFilm(models.Film f) throws java.rmi.RemoteException;
    public boolean insertFilm(models.Film f) throws java.rmi.RemoteException;
    public java.lang.String getAllFilms() throws java.rmi.RemoteException;
    public models.Film getFilmByName(java.lang.String filmName) throws java.rmi.RemoteException;
    public boolean deleteFilm(int filmID) throws java.rmi.RemoteException;
    public models.Film getFilmByID(int filmID) throws java.rmi.RemoteException;
}
