import { Elysia } from "elysia";

//A plugin
export const plugin = new Elysia()
.state('plugin-version', 1)
.get('/form-plugin', ()=> "Hi!")
.get('/greet', () => "Hello developer!")