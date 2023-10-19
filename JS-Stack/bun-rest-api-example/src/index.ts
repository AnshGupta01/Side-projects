import { Elysia } from "elysia";
import { plugin } from "./plugin";

//Application code
const app = new Elysia()
  .get("/", () => "Hello Bun dev, will use to create a rest api")
  .use(plugin)
  .state({
    id: 1,
    email: "ansh@gmail.com",
  })
  .decorate("getDate", () => Date.now());

app.get("/post/:id", ({ params: { id } }) => {
  return { id: id, title: "Learn bun " };
});

app.post("/post", ({ body, set, store }) => {
  console.log(store);
  set.status = 201;
  return body;
});

app.get("/track/*", () => {
  return "Track Route";
});

app.get("/tracks", ({ store, getDate }) => {
  console.log(store);
  console.log(getDate());
  console.log(store["plugin-version"]);

  return {
    "Movie-name": ["Harry Potter", "The Matrix", "Intersteller"],
  };
});

app.group("/v1", (app) =>
  app
    .get("/", () => "Version 1")
    .get("/ansh", () => {
      return {
        name: "ansh",
      };
    })
);

app.listen(3001);

console.log(
  `🦊 Elysia is running at ${app.server?.hostname}:${app.server?.port}`
);
