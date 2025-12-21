<script>
  let username = '';
  let password = '';

  async function handleLogin() {
    const response = await fetch('http://localhost:8080/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded',
      },
      body: new URLSearchParams({
        username,
        password,
      }),
    });

    if (response.ok) {
      // Redirect to a protected page (e.g., /recipes)
      window.location.href = '/recipes';
    } else {
      alert('Login failed!');
    }
  }
</script>

<form on:submit|preventDefault={handleLogin}>
  <input type="text" bind:value={username} placeholder="Username" />
  <input type="password" bind:value={password} placeholder="Password" />
  <button type="submit">Login</button>
</form>
