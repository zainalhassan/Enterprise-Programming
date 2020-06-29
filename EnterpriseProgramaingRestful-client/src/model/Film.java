package model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "film")
@XmlAccessorType (XmlAccessType.FIELD)

public class Film 
{
	private int FilmID;
	private String FilmName;
	private int FilmYear;
	private String FilmCredits;
	private int FilmDuration;
	private String FilmReview;

	public Film(int filmID, String filmName, int filmYear, String filmCredits, int filmDuration, String filmReview) 
	{
		super();
		this.FilmID = filmID;
		this.FilmName = filmName;
		this.FilmYear = filmYear;
		this.FilmCredits = filmCredits;
		this.FilmDuration = filmDuration;
		this.FilmReview = filmReview;
	}
	
	public Film()
	{
		
	}

	public int getFilmID() 
	{
		return FilmID;
	}

	public void setFilmID(int filmID) 
	{
		FilmID = filmID;
	}

	public String getFilmName() 
	{
		return FilmName;
	}

	public void setFilmName(String filmName) {
		FilmName = filmName;
	}

	public int getFilmYear() 
	{
		return FilmYear;
	}

	public void setFilmYear(int filmYear) 
	{
		FilmYear = filmYear;
	}

	public String getFilmCredits() 
	{
		return FilmCredits;
	}

	public void setFilmCredits(String filmCredits)
	{
		FilmCredits = filmCredits;
	}

	public int getFilmDuration() 
	{
		return FilmDuration;
	}

	public void setFilmDuration(int filmDuration) 
	{
		FilmDuration = filmDuration;
	}

	public String getFilmReview() 
	{
		return FilmReview;
	}

	public void setFilmReview(String filmReview) 
	{
		FilmReview = filmReview;
	}

	@Override
	public String toString() 
	{
		return "Film [FilmID=" + FilmID + ", FilmName=" + FilmName + ", FilmYear=" + FilmYear + ", FilmCredits=" + FilmCredits + ", FilmDuration=" + FilmDuration + ", FilmReview=" + FilmReview + "]";
	}

}
