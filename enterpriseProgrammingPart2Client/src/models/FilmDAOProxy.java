package models;

public class FilmDAOProxy implements models.FilmDAO {
  private String _endpoint = null;
  private models.FilmDAO filmDAO = null;
  
  public FilmDAOProxy() {
    _initFilmDAOProxy();
  }
  
  public FilmDAOProxy(String endpoint) {
    _endpoint = endpoint;
    _initFilmDAOProxy();
  }
  
  private void _initFilmDAOProxy() {
    try {
      filmDAO = (new models.FilmDAOServiceLocator()).getFilmDAO();
      if (filmDAO != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)filmDAO)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)filmDAO)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (filmDAO != null)
      ((javax.xml.rpc.Stub)filmDAO)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public models.FilmDAO getFilmDAO() {
    if (filmDAO == null)
      _initFilmDAOProxy();
    return filmDAO;
  }
  
  public boolean updateFilm(models.Film f) throws java.rmi.RemoteException{
    if (filmDAO == null)
      _initFilmDAOProxy();
    return filmDAO.updateFilm(f);
  }
  
  public boolean insertFilm(models.Film f) throws java.rmi.RemoteException{
    if (filmDAO == null)
      _initFilmDAOProxy();
    return filmDAO.insertFilm(f);
  }
  
  public java.lang.String getAllFilms() throws java.rmi.RemoteException{
    if (filmDAO == null)
      _initFilmDAOProxy();
    return filmDAO.getAllFilms();
  }
  
  public models.Film getFilmByName(java.lang.String filmName) throws java.rmi.RemoteException{
    if (filmDAO == null)
      _initFilmDAOProxy();
    return filmDAO.getFilmByName(filmName);
  }
  
  public boolean deleteFilm(int filmID) throws java.rmi.RemoteException{
    if (filmDAO == null)
      _initFilmDAOProxy();
    return filmDAO.deleteFilm(filmID);
  }
  
  public models.Film getFilmByID(int filmID) throws java.rmi.RemoteException{
    if (filmDAO == null)
      _initFilmDAOProxy();
    return filmDAO.getFilmByID(filmID);
  }
  
  
}