package com.github.MaryHrisanfova.BibliographySystem.utilities;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.MaryHrisanfova.BibliographySystem.model.Book;
import com.github.MaryHrisanfova.BibliographySystem.model.BookDetailed;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mariia_Khrisanfova
 */
public class JSONReader {
    public static List<Book> selectFiled(String idField, String field, String jsonData) {
        List<Book> fieldList = new ArrayList<>();
        try {
            JSONArray jsonarray = new JSONArray(jsonData);
            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                fieldList.add(new Book(jsonarray.getJSONObject(i).getLong(idField), jsonobject.getString(field)));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return fieldList;
    }

    public static BookDetailed selectObjectById(long id, String jsonData) {
        ObjectMapper mapper = new ObjectMapper();
        BookDetailed bookDetailed = new BookDetailed();
        try {
            JSONArray jsonarray = new JSONArray(jsonData);
            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                if (jsonobject.getLong("id") == id) {
                    bookDetailed = mapper.readValue(jsonobject.toString(), BookDetailed.class);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookDetailed;
    }
}
