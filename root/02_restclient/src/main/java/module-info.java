module io.github.wildcraft.restclient {
    requires httpcore; // no compilation problem
    requires httpclient; // no compilation problem
    requires commons.io; // shows compilation error
}