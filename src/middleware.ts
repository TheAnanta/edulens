import { NextResponse } from "next/server";
import type { NextRequest } from "next/server";

export function middleware(request: NextRequest) {
  const path = request.nextUrl.pathname;

  const isPublicPath = path === "/";

  const token = request.cookies.get("token")?.value || "";

  if (isPublicPath && !token) {
    return NextResponse.redirect(new URL("/", request.nextUrl));
  }

  return NextResponse.next();
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
  ],
};
