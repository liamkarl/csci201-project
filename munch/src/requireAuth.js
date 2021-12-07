

export default function requireAuth(nextState, replace, next) {
    var authenticated = false;
    if (!authenticated) {
      replace({
        pathname: "/login",
        state: {nextPathname: nextState.location.pathname}
      });
    }
    next();
  }

