package com.main.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.main.model.Comment;
import com.main.respository.CommentRepository;

@Service
public class CommentService implements ICommentService {

	@Autowired
	CommentRepository commentRepository;

	String postComment = "/posts/1/comments";

	RestTemplate restTemplate = new RestTemplate();

	@Override
	public String saveAllComment() throws Exception {

		getStringData(webScrape(postComment));

		return "Data Save Successfully";
	}

	@Override
	@Cacheable(value = "twenty-second-cache", key = "'CommentsCache'+#commentId")
	public List<Comment> getAllComment() {

		List<Comment> commentList = commentRepository.findAll();
		return commentList;
	}

//	Get Value from JSON format

	public static void getJsonData(String url) {
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

		client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body)
				.thenAccept(System.out::println).join();
	}

//	Get value JSON Object

	public String parseJsonData(String responseBody) {
		JSONArray comments = new JSONArray(responseBody);

		Comment commentModel = new Comment();

		for (int i = 0; i < comments.length(); i++) {
			JSONObject comment = comments.getJSONObject(i);

			commentModel.setPostId(comment.getInt("postId"));
			commentModel.setId(comment.getInt("id"));
			commentModel.setName(comment.getString("name"));
			commentModel.setEmail(comment.getString("email"));
			commentModel.setBody(comment.getString("body"));

			commentRepository.save(commentModel);

		}
		return null;
	}

	public void getStringData(String url) throws Exception {

		HttpURLConnection connection = null;

		BufferedReader reader;
		String line;
		StringBuffer responseContent = new StringBuffer();

		try {
			URL u = new URL(url);
			connection = (HttpURLConnection) u.openConnection();

			connection.setRequestMethod("GET");
			connection.setConnectTimeout(6000);
			connection.setReadTimeout(5000);

			int status = connection.getResponseCode();

			if (status > 299) {
				reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));

				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();

			} else {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

				while ((line = reader.readLine()) != null) {
					responseContent.append(line);
				}
				reader.close();

			}
			System.out.println(responseContent.toString());
			parseJsonData(responseContent.toString());

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			connection.disconnect();
		}

	}

	public String webScrape(String endPoint) throws Exception {
		Document doc = Jsoup.connect("https://jsonplaceholder.typicode.com/").get();

		String url = "https://jsonplaceholder.typicode.com";
		String fullUrl = null;

		for (Element main : doc.select("main")) {

			Elements tables = main.select("table");
			Element table = tables.get(1);
			Elements rows = table.select("tr");

			for (int i = 1; i < rows.size(); i++) {

				if (i <= 4) {

					Element row = rows.get(i);
					Elements cols = row.select("td");
					Element hyper = cols.select("a[href]").get(0);

					String linkhref = hyper.attr("href");

					if (linkhref.length() == endPoint.length()) {

						fullUrl = url + linkhref;

						System.out
								.println("-----------------------------" + fullUrl + "-------------------------------");

					}

				}
			}

		}
		return fullUrl;
	}

}
