package model;

import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

public class Film {

    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
    public static final SimpleDateFormat F = new SimpleDateFormat("dd/MM/yyyy");

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    private static int cnt;
    private int id;

    private String name;
    private String desc;
    private List<String> category;
    private Date release_day;
    private int view;

    private String slug;

    {
        id = ++cnt;

    }
    public Film(){};

    public Film(String name,String desc, List<String> category, String release_day, int view) throws ParseException {

        this.name = name;
        this.desc = desc;
        this.category = category;
        this.release_day = F.parse(release_day);
        this.view = view;
        this.slug = makeSlug(this.name);
    }

    @Override
    public String toString() {
        return String.format("id: %s - name: %s - slug: %s - desc: %s - category: %s - release day: %s - view: %s",this.id,this.name,this.slug,this.desc,this.category,F.format(this.release_day),this.view);
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public Date getRelease_day() {
        return release_day;
    }

    public void setRelease_day(Date release_day) {
        this.release_day = release_day;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public static String makeSlug(String input) {
        if (input == null)
            throw new IllegalArgumentException();

        String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
        String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }


}
