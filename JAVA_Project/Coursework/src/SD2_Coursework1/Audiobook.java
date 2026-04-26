package src.SD2_Coursework1;

/**
 * The Audiobook interface defines the structure for audiobook media.
 * DESIGN CHOICE:
 * Using an interface allows different types of audiobooks (e.g., CD format or Digital format) 
 * to share a common contract (methods like getAuthor and getNarrator) without forcing them 
 * into a single inheritance tree. This ensures flexibility and polymorphism.
 */
public interface Audiobook {
    public String getAuthor();
    public String getNarrator();
}