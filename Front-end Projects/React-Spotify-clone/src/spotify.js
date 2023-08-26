//https:developer.spotify.com/
//documentation/web-playback-sdk/quick-start/#

export const authEndpoint = "https://accounts.spotify.com/authorize";
const redirectUri = "http://localhost:3000/";
const clientId = "6216f756c75647068916f19e267bc33a";

const scopes = [
    "user-read-currently-playing",
    "user-read-recently-played",
    "user-read-playback-state",
    "user-top-read",
    "user-modify-playback-state",
];

// The code below will go to the # placeholder, remove it and split all places where there is &
//in the code, then it will return an array with all the key value pairs from the url
//http://localhost:3000/#access_token=BQCLm727CbdQOLMILQ-tE7Zr1QPc_OGahMw6HyuoT4nR4iXTLsRrYeIjuT0LV5BkjIGqn5SphF94BgMYAiy-9N5WR2Ca58XsD3EMAfW2TAV0ZIqtDR_k2icIWETIJX68QklewpZobsB9oshctWyd1tPmm0kPqnEcA3xwLAtqGYd-7f3vChqbuV8jOmxH4KIIO7iENdYHtEnRbAEh&token_type=Bearer&expires_in=3600

export const getTokenFromUrl = () => {
    return window.location.hash
        .substring(1)
        .split("&")
        .reduce((initial, item ) => {
            //#accessToken=mysupersecretkey&name=sonny&abc
            let parts = item.split("=");
            initial[parts[0]] = decodeURIComponent(parts[1]);
            return initial;
        }, {})
}

export const loginUrl = `${authEndpoint}?client_id=${clientId}&redirect_uri=${redirectUri}&scope=${scopes.join("%20")}&response_type=token&show_dialog=true`;