<script lang="ts">
    import { token } from "$lib/authStore";
    import { goto } from '$app/navigation';

    let username = '';
    let password = '';
    let isRegister = false;

    async function handleAuth() {
        const endpoint = isRegister ? 'register' : 'login';
        const res = await fetch(`http://localhost:8080/api/auth/${endpoint}`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username, password })
        });

        if (res.ok) {
            if (!isRegister) {
                const data = await res.json();
                token.set(data.token);
                goto('/recipes');
            } else {
                alert("Registered! Now login.");
                isRegister = false;
            }
        } else {
            alert("Error during authentication");
        }
    }
</script>

<main>
    <h1>{isRegister ? 'Registracija' : 'Prijava'}</h1>
    <form on:submit|preventDefault={handleAuth}>
        <input type="text" bind:value={username} placeholder="Uporabniško ime" required />
        <input type="password" bind:value={password} placeholder="Geslo" required />
        <button type="submit" class="primary">{isRegister ? 'Ustvari račun' : 'Vstopi'}</button>
    </form>
    <p on:click={() => isRegister = !isRegister} style="cursor:pointer">
        {isRegister ? 'Že imaš račun? Prijavi se.' : 'Nimaš računa? Registriraj se.'}
    </p>
</main>