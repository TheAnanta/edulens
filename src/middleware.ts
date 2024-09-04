import { NextResponse } from "next/server";
import type { NextRequest } from "next/server";

export function middleware(request: NextRequest) {
  const path = request.nextUrl.pathname;
  const name = request.cookies.get("name")?.value || "";

  // Define public paths (accessible without login)
  const isPublicPath = path === "/" || path === "/login";

  if (isPublicPath && name) {
    // Redirect logged-in users from public paths to profile
    return NextResponse.redirect(new URL("/profile", request.nextUrl));
  } else if (!isPublicPath && name === "") {
    // Redirect non-logged-in users to login from protected paths
    return NextResponse.redirect(new URL("/login", request.nextUrl));
  }
}

export const config = {
  matcher: [ 
    "/",
    "/achievements",
    "/analytics",
    "/attendance",
    "/courses",
    "/events",
    "/feedback",
    "/infrastructure",
    "/placements",
    "/profile",
    "/research-publications",
    "/resource-center",
    "/salary",
    "/trends",
    "/timetable",
    "/login",
  ],
};
