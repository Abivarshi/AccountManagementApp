///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package accountmanagement.database;
//
//import com.google.api.client.http.GenericUrl;
//import com.google.api.client.http.HttpResponse;
//
//import com.google.api.client.auth.oauth2.Credential;
//import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
//import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
//import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.JsonFactory;
//import com.google.api.client.json.jackson2.JacksonFactory;
//import com.google.api.client.util.store.FileDataStoreFactory;
//import com.google.api.services.drive.Drive;
//import com.google.api.services.drive.DriveScopes;
//import com.google.api.services.drive.model.File;
//import com.google.api.services.drive.model.FileList;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.security.GeneralSecurityException;
//import java.util.Collections;
//import java.util.List;
///**
// *
// * @author acer
// */
//public class BackUp {
//
//    private static final String APPLICATION_NAME = "Google Drive API Java Quickstart";
//    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
//    private static final String TOKENS_DIRECTORY_PATH = "tokens";
//
//    /**
//     * Global instance of the scopes required by this quickstart.
//     * If modifying these scopes, delete your previously saved tokens/ folder.
//     */
//    private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE_METADATA_READONLY);
//    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
//
//    /**
//     * Creates an authorized Credential object.
//     * @param HTTP_TRANSPORT The network HTTP Transport.
//     * @return An authorized Credential object.
//     * @throws IOException If the credentials.json file cannot be found.
//     */
//    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
//        // Load client secrets.
//        InputStream in = BackUp.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
//        if (in == null) {
//            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
//        }
//        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
//
//        // Build flow and trigger user authorization request.
//        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
//                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
//                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
//                .setAccessType("offline")
//                .build();
//        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
//        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
//    }
//
//    public static void main(String... args) throws IOException, GeneralSecurityException {
//        // Build a new authorized API client service.
//        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
//        Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
//                .setApplicationName(APPLICATION_NAME)
//                .build();
//
//        // Print the names and IDs for up to 10 files.
//        FileList result = service.files().list()
//                .setPageSize(10)
//                .setFields("nextPageToken, files(id, name)")
//                .execute();
//        List<File> files = result.getFiles();
//        if (files == null || files.isEmpty()) {
//            System.out.println("No files found.");
//        } else {
//            System.out.println("Files:");
//            for (File file : files) {
//                System.out.printf("%s (%s)\n", file.getName(), file.getId());
//            }
//        }
//    }
//
//    
//    /**
//   * Print a file's metadata.
//   *
//   * @param service Drive API service instance.
//   * @param fileId ID of the file to print metadata for.
//   */
//  private static void printFile(Drive service, String fileId) {
//
//    try {
//      File file = service.files().get(fileId).execute();
//
//      System.out.println("Title: " + file.getTitle());
//      System.out.println("Description: " + file.getDescription());
//      System.out.println("MIME type: " + file.getMimeType());
//    } catch (IOException e) {
//      System.out.println("An error occurred: " + e);
//    }
//  }
//
//  /**
//   * Download a file's content.
//   *
//   * @param service Drive API service instance.
//   * @param file Drive File instance.
//   * @return InputStream containing the file's content if successful,
//   *         {@code null} otherwise.
//   */
//  private static InputStream downloadFile(Drive service, File file) {
//    if (file.getDownloadUrl() != null && file.getDownloadUrl().length() > 0) {
//      try {
//        HttpResponse resp =
//            service.getRequestFactory().buildGetRequest(new GenericUrl(file.getDownloadUrl()))
//                .execute();
//        return resp.getContent();
//      } catch (IOException e) {
//        // An error occurred.
//        e.printStackTrace();
//        return null;
//      }
//    } else {
//      // The file doesn't have any content stored on Drive.
//      return null;
//    }
//  }
//    /**
//    public static void getBackUp() {
//        File source = new File("D:\\D\\AccountManagement\\shop.db");
//        File dest = new File("D:\\D\\KARAN\\Deploy\\shop.db");
//        try {
//            copyFile(source, dest);
//        } catch (IOException e) {
//            Logger.getLogger(BackUp.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }
//
//    private static void copyFile(File sourceLocation, File targetLocation)
//            throws IOException {
//
//        InputStream in = new FileInputStream(sourceLocation);
//        OutputStream out = new FileOutputStream(targetLocation);
//
//        // Copy the bits from instream to outstream
//        byte[] buf = new byte[1024];
//        int len;
//        while ((len = in.read(buf)) > 0) {
//            out.write(buf, 0, len);
//        }
//        in.close();
//        out.close();
//    }
//    * */
//}
