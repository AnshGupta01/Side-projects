import figlet from "figlet";

const server = Bun.serve({
    port: 3001,
    fetch(req){
        const url = new URL(req.url)

        if(url.pathname === '/'){
            return new Response(figlet.textSync("Hola"))
        }

        if(url.pathname === '/about'){
            return new Response(figlet.textSync("About me !"))
        }

        if(url.pathname === '/greet'){
            return new Response(Bun.file('./greet.txt'))
        }

        return new Response('404!?')
    }
})

console.log(`listening on port http://localhost:${server.port}`);