"use client";
import { useRouter } from "next/navigation";
import { useState } from "react";

export default function Page() {
  const [username, setUsername] = useState<String>("");
  const router = useRouter();
  function handleInput(e: any) {
    setUsername(e.target.value);
  }

  function handleSignUp() {
    if (username.length > 0) {
      const user = username.split("@")[0];
      router.push(`/profile/${user}`);
    }
  }

  return (
    <div className="flex relative justify-between">
      <div className="pt-24 px-16 w-[40%] h-screen flex flex-col items-start justify-start">
        <h1 className="uppercase text-lg mb-2">WELCOME TO EDULENS</h1>
        <h2 className="text-3xl uppercase mb-4">Get Started</h2>
        <p className="mb-4">
          Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse amet
          nulla exercitationem vero commodi, deserunt quo molestiae aliquam
          eligendi explicabo veritatis.
        </p>
        <div className="flex flex-col space-y-2 w-full">
          <input
            onChange={handleInput}
            type="text"
            title="username"
            placeholder="@username"
            className="py-4 px-8 rounded-full border border-neutral-400 mr-4 w-full"
          />
          <input
            type="password"
            title="password"
            placeholder="password"
            className="py-4 px-8 rounded-full border border-neutral-400 w-full"
          />
        </div>
        <button
          onClick={handleSignUp}
          className="mt-6 text-lg rounded-full py-3 px-6 font-bold border border-neutral-400 w-full"
        >
          SignUp
        </button>
      </div>
      <img
        src="/study.svg"
        alt="study"
        className="bottom-0 right-[20%] absolute z-50 pointer-events-none"
      />
      <div className="w-[10%]">
        <img src="/gray.svg" alt="study" className="absolute z-10" />
      </div>

      <div className="bg-[var(--main-color)]  w-[40%] right-[60%]">
        <div className="rotate-90 absolute text-white text-xl gap-x-6">
          <img src="/text.svg" alt="" className="h-full" />
          <img src="/text.svg" alt="" className="h-full" />
          <img src="/text.svg" alt="" className="h-full" />
        </div>
      </div>
    </div>
  );
}
